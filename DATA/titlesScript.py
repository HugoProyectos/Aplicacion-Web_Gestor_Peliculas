with open("title.spanish.txt", "r", encoding="utf-8") as f:
    pretitleID = f.readlines()

titleID = []
for a in pretitleID:
    titleID.append(a[0:9])
    

myList = [i.split('\t')[2] for i in pretitleID] 


genres= []
with open("title.basics.tsv", "r", encoding="utf-8") as g:
    for i in range(100000):
        genres.append(g.readline())



listaAux = []
idList = []
namesList = []
print("Empieza bucle")
for i in range(len(titleID)):
    if titleID[i] == titleID[i-1] and not i == len(titleID)-1:
        continue
    for a in range(len(genres)): 
        #print(genres[a].split('\t')[0])
        if genres[a].split('\t')[0] == titleID[i]:
            print("si!")
            idList.append(titleID[i].split('\t')[0])
            listaAux.append(genres[a].split('\t')[8].replace("\n",""))
            namesList.append(myList[i])
    

print("Empieza a escribir")

with open("./SQL/Obras.sql", "w", encoding="utf-8") as l:
    PREFIX = "INSERT INTO OBRA (Obra_id,Titulo, Descripcion, Genero) VALUES ("
    SUFIX = ");\n"
    for i in range(len(idList)):
        l.write(PREFIX + "'" + idList[i] + "','" + namesList[i].replace("'", "") + "','" + "/N" + "','" + listaAux[i] + "'" + SUFIX)
