import sys
import twl

class letterFreq(object):

    def __init__(self, name, val):
        self.n = name
        self.f = val
        self.lchild = None
        self.rchild = None

    def __repr__(self):
        return repr((self.n, self.f))

    def compare(item1, item2):
        if item1.f < item2.f:
            return -1
        elif item1.f > item2.f:
            return 1
        else:
            return 0

    def setChildren(self, lc,rc):
        self.lchild = lc
        self.rchild = rc

def decipher(ciphertext):
    engl_letter_freq = {}
if __name == "__main__":
    if len(sys.argv) < 4:
        print("three arguments required: ciphertext_filename outputplaintext_filename key_filename")
    f_in = open(sys.argv[1], 'r')
    inp = f_in.read();
    ciphertext = decipher(inp)
