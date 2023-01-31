Fichero = []
ObraID = []
PersonaID = []
PersonaRole = []
with open("title.principals.tsv", "r", encoding="utf-8") as f:
    for i in range(100000):
        Fichero.append(f.readline())
for i in range (100000):
    ObraID.append(Fichero[i].split('\t')[0])
    PersonaID.append(Fichero[i].split('\t')[2])
    PersonaRole.append(Fichero[i].split('\t')[3])
print("Empieza a escribir")

with open("./SQL/Obra_Persona.sql", "w", encoding="utf-8") as l:
    PREFIX = "INSERT INTO OBRA_PERSONA (Obra_id, Persona_id, Relacion) VALUES ("
    SUFIX = ");\n"
    for i in range(len(ObraID)):
        l.write(PREFIX + "'" + ObraID[i] + "','" + PersonaID[i] + "','" + PersonaRole[i] + "'" + SUFIX)
