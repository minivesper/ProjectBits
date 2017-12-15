import math

global gen_num
gen_num = True

def next_num(init_num, index):
    global gen_num
    init_num[index] = init_num[index] + 1
    if init_num[index] == 10:
        if index == 0:
            gen_num = False
            print(init_num)
            return init_num
        init_num[index] = 1
        init_num = next_num(init_num, index - 1)
        return init_num
    else:
        return init_num

def checkSum(num):
    if(sum(num) != 2*len(num) + 1):
        return False
    else:
        return True

def addSol(final, init, ex):
    arg = []
    for i in range(len(init)):
        arg.append((init[i]*10) + ex[i])
    # print(arg)
    num = ""
    for i in range(len(arg)):
        num += str(arg[i])
    num += "10"
    final.append(int(num))

def checkVain(st, en):
    init = st.copy()
    init.append(1)
    exp = en.copy()
    exp.append(0)
    check = True
    for i in range(len(init)):
        counter = 0
        for j in range(len(exp)):
            if exp[i] == exp[j]:
                counter = counter + 1
            if exp[i] == init[j]:
                counter = counter + 1
        if counter != init[i]:
            check = False
    return check

if __name__ == "__main__":
    print(checkVain([7,3,2,1,1,1,2,1,1],[1,2,3,4,5,6,7,8,9]))
    vain_nums = []
    # init_num = [1, 1, 1, 1, 1, 1, 1, 1, 1]
    # expand_num = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    init_num = [1, 1, 1]
    expand_num = [1, 2, 3]
    while gen_num:
        init_num = next_num(init_num, len(init_num) - 1)
        if checkSum(init_num):
            if checkVain(init_num, expand_num):
                addSol(vain_nums, init_num, expand_num)
    print(vain_nums)
    print("number of vain solutions:", len(vain_nums))
    print("total number of solutions", math.factorial(len(init_num) + 1)*len(vain_nums))
