import sys

def decipher(ciphertext, key):
    ciphertext = ciphertext.lower()
    plaintext = ""
    for c in ciphertext:
        if c in key:
            plaintext = plaintext + key[c]
    return plaintext

if __name__ == "__main__":
    if len(sys.argv) < 4:
        print("three arguments required: plaintext_filename cipertext_filename key_filename")
    s = open(sys.argv[3], 'r').read()
    key = eval(s)
    print(key)
    key_swap = {y:x for x,y in key.items()}
    print(key_swap)
    f_in = open(sys.argv[2], 'r')
    inp = f_in.read();
    print(inp)
    plaintext = decipher(inp, key_swap)
    plain_out = open(sys.argv[1], 'w')
    plain_out.write(plaintext)
