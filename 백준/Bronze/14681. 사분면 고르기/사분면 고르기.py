x = input()
y = input()
if int(x)*int(y) > 0:
    if int(x) > 0:
        print("1")
    else:
        print("3")
else:
    if int(x) > 0:
        print("4")
    else:
        print("2")
