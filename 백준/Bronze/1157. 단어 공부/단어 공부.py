s = input().lower()

count = {}

for letter in s:
    if letter in count:
        count[letter] +=1
    else:
        count[letter] = 1
        
max_count = max(count.values())
max_letters = [letter for letter, count in count.items() if count == max_count]

if len(max_letters) >1:
    print("?")
else:
    print(max_letters[0].upper())