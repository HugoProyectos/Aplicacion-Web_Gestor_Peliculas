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
inicioList = []
FinalList = []
print("Empieza bucle")
for i in range(len(titleID)):
    for a in range(len(genres)): 
        #print(genres[a].split('\t')[0])
        if genres[a].split('\t')[0] == titleID[i]:
            if genres[a].split('\t')[1] == "tvSeries":
                print("si!")
                idList.append(genres[a].split('\t')[0])
                inicioList.append(genres[a].split('\t')[5])
                FinalList.append(genres[a].split('\t')[6])
                

print("Empieza a escribir")

with open("./SQL/Series.sql", "w", encoding="utf-8") as l:
    PREFIX = "INSERT INTO SERIE (Obra_id, Inicio, Final) VALUES ("
    SUFIX = ");\n"
    for i in range(len(idList)):
        l.write(PREFIX + "'" + idList[i] + "','"  + inicioList[i] + "','"  + FinalList[i] + "'" + SUFIX)