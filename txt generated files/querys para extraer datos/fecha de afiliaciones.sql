select "nombre",nrobeneficiario,DATE_FORMAT(STR_TO_DATE(fechaAfiliacion,'%m/%d/%Y'),'%d/%m/%Y'),"empresa","desAgencia" 
from fechasdeafiliacion group by nroBeneficiario