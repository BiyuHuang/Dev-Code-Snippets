#!/bin/bash

if $# < 2
	echo "<Usage> sh sync.sh Param[data_path] "
fi

targetPath = $1
cd $targetPath

displicli=$( find / -name 'displicli')

:> temp.ctl
:> filelist
`ls -l |awk -F ' ' '{print $9}'` >> FileList

for f in $(cat filelist)
do
	if [test -f $f] && [$f != "FileList"] && [$ != "sync.sh"]
	then
		file_name=`ls $f |awk -F '#' '{print $2}'`
		echo "[" + $f + "]" >> temp.ctl
		echo "tablename" >> temp.ctl
		echo "`$displicli temp.ctl`"
		echo "Sync $f success."
	else
		echo "Process was done!"
	fi  
done

echo "[Exit $?]"
