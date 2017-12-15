import sys

class codeObj(object):

    def __init__(self, name, val):
        self.n = name
        self.v = val
        self.lchild = None
        self.rchild = None

    def __repr__(self):
        return repr((self.n, self.v))

    def compare(item1, item2):
        if item1.v < item2.v:
            return -1
        elif item1.v > item2.v:
            return 1
        else:
            return 0

    def setChildren(self, lc,rc):
        self.lchild = lc
        self.rchild = rc

def sortInput(inp):
    appearance_dict = {}
    for char in inp:
        if char in appearance_dict:
            appearance_dict[char] = appearance_dict[char] + 1
        else:
            appearance_dict[char] = 1;
    code_objs = []
    for c in appearance_dict:
        co = codeObj(c, appearance_dict[c])
        code_objs.append(co)
    code_objs = sorted(code_objs, key=lambda codename: codename.v)
    return code_objs

def buildHTree(chars):
    while len(chars) > 1:
        firstChild = chars.pop(0)
        secondChild = chars.pop(0)
        parent = codeObj(firstChild.n + secondChild.n, firstChild.v + secondChild.v)
        parent.setChildren(firstChild,secondChild)
        chars.append(parent)
        chars = sorted(chars, key=lambda codename: codename.v)
    root = chars.pop(0)
    return root

def generateCodesfromTree(root, codedict, codeString):
    if root.lchild and root.rchild:
        generateCodesfromTree(root.lchild, codedict, codeString + '0')
        generateCodesfromTree(root.rchild, codedict, codeString + '1')
    if not root.lchild and not root.rchild:
        codedict[root.n] = codeString
    return codedict

def encodeText(plaintext, key):
    encodedText = ""
    print(key)
    for c in plaintext:
        encodedText = encodedText + key[c]
    return encodedText

def huffmanEncode(inp):
    sorted_chars = sortInput(inp)
    HuffmanTreeRoot = buildHTree(sorted_chars);
    codeDict = {}
    codeDict = generateCodesfromTree(HuffmanTreeRoot, codeDict, "")
    encodedText = encodeText(inp, codeDict)
    return encodedText

if __name__ == "__main__":
    f_in = open(sys.argv[1], 'r')
    inp = f_in.read();
    out = [inp,huffmanEncode(inp)]
    out = str(out)
    f_out = open(sys.argv[2], 'w')
    f_out.write(out)
