select name,IFNULL((select tipoDoc from tipodocandfechanac where nroDoc=dniNumber group by nroDoc),'DNI') as tipoDoc,dniNumber,address,phoneNumber,
IFNULL((select DATE_FORMAT(STR_TO_DATE(fechaNac,'%m/%d/%Y'),'%d/%m/%Y') from tipodocandfechanac where nroDoc=dniNumber group by nroDoc),'2/1/1931') as 
fechaNac,sex,replace(beneficiaryNumber,"-","") as beneficiaryNumber
from Patients

