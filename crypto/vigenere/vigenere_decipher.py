import sys
from collections import deque

def shift(key, array):
    a = deque(array) # turn list into deque
    a.rotate(-1*key)    # rotate deque by key
    return list(a)   # turn deque back into a list

def genVbox():
    vbox = {}
    vbox["B"] = ["b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","a"]
    for i in range(1, len(vbox["B"])):
        temp = shift(i, vbox["B"])
        vbox[vbox["B"][i].upper()] = temp
    return vbox

def gencodeDict(codename, ciphertext):
    alphabet  = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    codenameKey =[]
    for i in range(len(ciphertext)):
        if ciphertext[i] in alphabet:
            codenameKey.append([ciphertext[i], codename[i%len(codename)].upper()])
        else:
            codenameKey.append([ciphertext[i], " "])
    return codenameKey

def vDecipher(ciphertext, codeKey, vbox):
    alphabet  = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    plaintext = ""
    for i in range(len(codeKey)):
        if codeKey[i][0] in alphabet:
            plaintext = plaintext + alphabet[vbox[codeKey[i][1]].index(codeKey[i][0])]
        else:
            plaintext = plaintext +  codeKey[i][1]
    return plaintext

def vigenere_decipher(ciphertext, codename):
    vigenere_box = genVbox();
    plaintext_codeDict = gencodeDict(codename, ciphertext)
    plaintext = vDecipher(ciphertext, plaintext_codeDict, vigenere_box)
    return plaintext

if __name__ == "__main__":
    codephrase = None
    if len(sys.argv) < 4:
        print("three arguments required: plaintext_filename ciphertext_filename codephrase")
    codephrase = sys.argv[3]
    f_in = open(sys.argv[2], 'r')
    inp = f_in.read();
    plaintext = vigenere_decipher(inp, codephrase)
    cip_out = open(sys.argv[1], 'w')
    cip_out.write(plaintext)
