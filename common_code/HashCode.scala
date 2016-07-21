object HashDemo extends App{
  def rsHash(value: String): Long = {
    var a = 63689
    val b = 378551
    var hashCode: Long = 0
    (0 until value.length).foreach {
      i =>
        hashCode = hashCode * a + value.charAt(i).toString.toInt
        a = a * b
    }
    hashCode
  }

  def jsHash(value: String): Long = {
    val hashCode = 1315423911
    var res: Long = 0
    (0 until value.length).foreach {
      i =>
        res = hashCode ^ ((hashCode << 5) + value.charAt(i).toString.toInt + (hashCode >> 2))
    }
    res
  }

  def pjwHash(value: String): Long = {
    val bitsInUnsignedInt: Long = 4 * 8
    val threeQuarters: Long = (bitsInUnsignedInt * 3) / 4
    val oneEighth: Long = bitsInUnsignedInt / 8
    val highBits: Long = 0xFFFFFFFF << (bitsInUnsignedInt - oneEighth)
    var hashCode: Long = 0
    var test: Long = 0
    (0 until value.length).foreach {
      i =>
        hashCode = (hashCode << oneEighth) + value.charAt(i).toString.toInt
        test = hashCode & highBits
        if (test != 0) {
          hashCode = (hashCode ^ (test >> threeQuarters)) & (~highBits)
        }
    }
    hashCode
  }

  def elfHash(value: String): Long = {
    var hashCode: Long = 0
    var x: Long = 0
    (0 until value.length).foreach {
      i =>
        hashCode = (hashCode << 4) + value.charAt(i).toString.toInt
        if ((x = hashCode & 0xF0000000L) != 0) {
          hashCode ^= (x >> 24)
          hashCode &= ~x
        }
    }
    hashCode
  }

  def bkdrHash(value: String): Long = {
    val seed: Long = 131
    var hashCode: Long = 0
    (0 until value.length).foreach {
      i =>
        hashCode = (hashCode * seed) + value.charAt(i).toString.toInt
    }
    hashCode
  }

  def sdbmHash(value: String): Long = {
    var hashCode: Long = 0
    (0 until value.length).foreach {
      i =>
        hashCode = value.charAt(i).toString.toInt + (hashCode << 6) + (hashCode << 16) - hashCode
    }
    hashCode
  }

  def djbHash(value: String): Long = {
    var hashCode: Long = 5381
    (0 until value.length).foreach {
      i =>
        hashCode = ((hashCode << 5) + hashCode) + value.charAt(i).toString.toInt
    }
    hashCode
  }

  def dekHash(value: String): Long = {
    var hashCode = value.length
    (0 until value.length).foreach {
      i =>
        hashCode = ((hashCode << 5) ^ (hashCode >> 27)) ^ value.charAt(i).toString.toInt
    }
    hashCode
  }

  def bpHash(value: String): Long = {
    var hashCode = 0
    (0 until value.length).foreach {
      i =>
        hashCode = hashCode << 7 ^ value.charAt(i).toString.toInt
    }
    hashCode
  }

  def fnvHash(value: String): Long = {
    val fnv_prime = 0x811C9DC5
    var hashCode = 0
    (0 until value.length).foreach {
      i =>
        hashCode *= fnv_prime
        hashCode ^= value.charAt(i).toString.toInt
    }
    hashCode
  }

  def apHash(value: String): Long = {
    var hashCode = 0xAAAAAAAA
    (0 until value.length).foreach {
      i =>
        if ((i & 1) == 0) {
          hashCode ^= ((hashCode << 7) ^ value.charAt(i).toString.toInt ^ (hashCode >> 3))
        } else {
          hashCode ^= (~((hashCode << 11) ^ value.charAt(i).toString.toInt ^ (hashCode >> 5)))
        }
    }
    hashCode
  }
}
