
def rec_fib(prev, curr, n, stop):
    if(n >= stop):
        return curr
    n=n+1
    new_curr = prev + curr
    prev = curr
    curr = fib(prev, new_curr, n, stop)
    return curr

def loop_fib(stop):
    prev = 1
    curr = 1
    for i in range(stop - 2):
         new_curr = prev + curr
         prev = curr
         curr = new_curr
    return curr

if __name__ == "__main__":
    dec_inp = input("which style 'rec or loop': ")
    if(dec_inp == "rec"):
        inp = int(input("nth fib number desired?: "))
        final = rec_fib(1,1,2,inp)
        print(final)
    elif(dec_inp == "loop"):
        inp = int(input("nth fib number desired?: "))
        final = loop_fib(in p)
        print(final)
