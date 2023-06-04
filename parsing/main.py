from bs4 import BeautifulSoup
import requests
import json

url = "http://ufcstats.com/statistics/events/completed?page=all"

# headers = {
#     "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7",
#     "User-Agent":  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.57"
# }

headers = {
    "Accept": "*/*",
    "User-Agent":  "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.57"
}
# req = requests.get(url, headers=headers)
# src = req.text

#ЗАПИСЬ ОСНОВНОЙ СТРАНИЦЫ В ФАЙЛ
# with open("parsing/ufc.html", "w") as file:
#     file.write(src)

#НАХОЖДЕНИЕ ССЫЛОК НА ДОП СТРАНИЦЫ 
# with open('parsing/ufc.html') as file:
#     src = file.read()
# soup = BeautifulSoup(src, "lxml")

# all_days_hrefs = soup.find_all(class_='b-link b-link_style_black')

#ЗАПИСЬ ССЫЛОК В ОТДЕЛЬНЫЙ ФАЙЛ
# with open('parsing/links.txt', 'w') as f:
        
#     for i in all_days_hrefs:
#         #print(i)
#         item_href = i.get("href")
#         print(item_href)
#         f.write(item_href+'\n')
#         #json.dump(item_href, f, indent=4, ensure_ascii=False)
        

count = 1
links = []
with open('parsing/links.txt') as f:
    for i in f:
        links.append(i[:-1])




# print(links)
# print(len(links))

#ЗАПИСЬ ДОП СТРАНИЦ В ПАПКУ
# #ERROR
# errors = []
# for i in links:
#     req = requests.get(url=i, headers=headers)
#     src = req.text
#     with open(f'parsing/pages/page_{count}.html','w') as page:
#         try:
#             page.write(src)
#         except: 
#             errors.append(count)
#     count += 1
# print(errors)

#ОБРАБОТКА СТРАНИЦ




data = []
for i in range(len(links)):
    
    with open(f'parsing/pages/page_{i+1}.html') as file:
        src = file.read()

    soup = BeautifulSoup(src, "lxml")
    table_day = soup.find_all(class_="b-fight-details__table-row b-fight-details__table-row__hover js-fight-details-click")

# ОБРАБОТКА ТАБЛИЦЫ БОЕВ ЗА ДЕНЬ
    fights = []
    for row in table_day:
        res = {}
        winner, loser = row.find_all(class_="b-link b-link_style_black")
        weight_class = row.find_all('p', class_="b-fight-details__table-text")
        res = {'Winner' : winner.text.strip(),'Loser' : loser.text.strip(),'Weight class' : weight_class[11].text.strip()}

        fights.append(res)

    for i in fights:    
        data.append(i)
    print(len(data))

# print(data)



# ИТОГОВЫЙ ВЫВОД
with open('parsing/data.json', 'w') as file:
    for i in data:
        json.dump(i, file, indent=4, ensure_ascii=False)





