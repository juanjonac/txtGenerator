select  replace(header.patientId,"-","") as nroAfiliado, header.WO_id as nroOP ,type_of_service,  serviceId  
/*las primeras 3 columnas pueden repetirse*/
from wo_headers as header, wo_details as detail 
where header.WO_id=detail.WO_originalId