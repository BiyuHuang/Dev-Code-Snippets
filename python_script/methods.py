def parrot(voltage,state='a stiff',action='voom',type='Norwegian Blue'):
    print("-- This parrot wouldn't", action, end=' ')
    print("if you put", voltage, "volts through it.")
    print("-- Lovely plumage, the", type)
    print("-- It's", state, "!")


def return_sum(x,y):
     c = x + y
     return c

def empty_return(x,y):
     c = x + y
     return

def arithmetic_mean(*args):
     sum = 0
     for x in args:
          sum += x
     return sum
