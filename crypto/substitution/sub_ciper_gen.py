import sys
import random

def keygen(jcphrase):
    alphabet = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"," "]
    alpha2 = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z", " "]
    key = {}
    if jcphrase != None:
        for c in jcphrase:
            key[alphabet[0]] = c
            alphabet.pop(0)
            alpha2.remove(c)
    while len(alphabet) > 0:
        codeLet= random.choice(alpha2)
        key[alphabet[0]] = codeLet
        alphabet.pop(0)
        alpha2.remove(codeLet)
    return key

def encipher(plaintext, key):
    plaintext = plaintext.lower()
    ciphertext = ""
    for c in plaintext:
        if c in key:
            ciphertext = ciphertext + key[c]
    return ciphertext

if __name__ == "__main__":
    jcphrase = None
    if len(sys.argv) < 4:
        print("three arguments required: plaintext_filename cipertext_filename key_filename")
    if len(sys.argv) > 4 and sys.argv[4] == "-jc":
        if len(sys.argv) < 6:
            print("jc option requires an extra argument which is the keyphrase and the keyphrase may not have repeated letters")
        else:
            jcphrase = sys.argv[5]
    key = keygen(jcphrase)
    f_out = open(sys.argv[3], 'w')
    f_out.write(str(key))
    f_in = open(sys.argv[1], 'r')
    inp = f_in.read();
    ciphertext = encipher(inp, key)
    cip_out = open(sys.argv[2], 'w')
    cip_out.write(ciphertext)
