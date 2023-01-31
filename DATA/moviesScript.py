with open("title.spanish.txt", "r", encoding="utf-8") as f:
    pretitleID = f.readlines()

titleID = []
for a in pretitleID:
    titleID.append(a[0:9])

genres= []
with open("title.basics.tsv", "r", encoding="utf-8") as g:
    for i in range(100000):
        genres.append(g.readline())


idList = []
namesList = []
print("Empieza bucle")
for i in range(len(titleID)):
    for a in range(len(genres)): 
        #print(genres[a].split('\t')[0])
        if genres[a].split('\t')[0] == titleID[i]:
            if genres[a].split('\t')[1] == "movie":
                print("si!")
                idList.append(genres[a].split('\t')[0])

print("Empieza a escribir")

with open("./SQL/Peliculas.sql", "w", encoding="utf-8") as l:
    PREFIX = "INSERT INTO PELICULA (Obra_id) VALUES ("
    SUFIX = ");\n"
    for i in range(len(idList)):
        l.write(PREFIX + "'" + idList[i] + "'" + SUFIX)