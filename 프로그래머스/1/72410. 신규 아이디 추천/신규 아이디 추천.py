def solution(new_id):
    answer = ''
    temp = ''
    new_id = new_id.lower() #1
    
    for i in range(len(new_id)):
        if new_id[i].isnumeric() or new_id[i].isalpha() or new_id[i] == '_' or new_id[i] == '-' or new_id[i] == '.':
            temp += new_id[i]
    new_id = temp #2
    
    while True:
        if '..' in new_id:
            new_id = new_id.replace('..', '.')
        else:
            break #3
    
    new_id = new_id.strip('.') #4
    
    if len(new_id) == 0 :
        new_id = 'a' #5
    
    if len(new_id) >= 16:
        new_id = new_id[:15] #6
        new_id = new_id.rstrip('.')
    while len(new_id) < 3:
        new_id += new_id[-1] #7
        
    answer = new_id
    
    return answer