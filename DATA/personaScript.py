Fichero = []
PersonaNID = []
PersonaName = []
with open("name.basics.tsv", "r", encoding="utf-8") as f:
    for i in range(1000000):
        Fichero.append(f.readline())
        PersonaNID.append(Fichero[i].split('\t')[0])
        PersonaName.append(Fichero[i].split('\t')[1])
        


print("Empieza a escribir")

with open("./SQL/Persona.sql", "w", encoding="utf-8") as l:
    PREFIX = "INSERT INTO PERSONA (Persona_id, Nombre) VALUES ("
    SUFIX = ");\n"
    for i in range(len(PersonaNID)):
        l.write(PREFIX + "'" + PersonaNID[i] + "','" + PersonaName[i].replace("'", "") + "'" + SUFIX)