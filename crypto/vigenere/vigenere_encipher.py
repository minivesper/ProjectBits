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

def gencodeDict(codename, plaintext):
    alphabet  = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    codenameKey =[]
    for i in range(len(plaintext)):
        if plaintext[i] in alphabet:
            codenameKey.append([plaintext[i], codename[i%len(codename)].upper()])
        else:
            codenameKey.append([plaintext[i], " "])
    return codenameKey

def vEncipher(plaintext, key_dict, vbox):
    alphabet  = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    ciphertext = ""
    for c in range(len(key_dict)):
        if plaintext[c] in alphabet:
            ciphertext = ciphertext + vbox[key_dict[c][1]][alphabet.index(key_dict[c][0])]
        else:
            ciphertext = ciphertext + key_dict[c][1]
    return ciphertext

def vigenere_encipher(plaintext, codename):
    vigenere_box = genVbox();
    plaintext_codeDict = gencodeDict(codename, plaintext)
    ciphertext = vEncipher(plaintext, plaintext_codeDict, vigenere_box)
    return ciphertext

if __name__ == "__main__":
    codephrase = None
    if len(sys.argv) < 4:
        print("three arguments required: plaintext_filename cipertext_filename codephrase")
    codephrase = sys.argv[3]
    f_in = open(sys.argv[1], 'r')
    inp = f_in.read();
    ciphertext = vigenere_encipher(inp, codephrase)
    cip_out = open(sys.argv[2], 'w')
    cip_out.write(ciphertext)
