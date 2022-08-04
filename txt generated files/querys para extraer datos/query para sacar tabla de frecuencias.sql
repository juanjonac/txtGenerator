select  replace(header.patientId,"-","") as nroAfiliado, header.WO_id as nroOP ,type_of_service, frecuencias.codigoTXT,frecuencias.frecuencia,frecuencias.ocurrencia,
serviceId  as estatico,fechas.fechaInicio,fechas.fechaVencimiento,DATE_FORMAT(STR_TO_DATE('06/30/2022', '%m /%d /%Y'),'%d/%m/%Y') as  fechaLimiteVencimiento 
/*las primeras 3 columnas pueden repetirse*/
from wo_headers as header, wo_details as detail ,fechas_inicio_vto as fechas, frecuenciasmatcher as frecuencias
where header.WO_id=detail.WO_originalId and fechas.nroOP=header.WO_id and detail.WO_originalId=fechas.nroOP 
and frecuencias.tipoServicio=detail.type_of_service and frecuencias.codigoEstatico=detail.serviceId 
and  DATE_FORMAT(STR_TO_DATE(fechas.fechaVencimiento,'%d/%m/%Y'),'%d/%m/%Y') >= DATE_FORMAT(STR_TO_DATE('07/01/2022', '%m /%d /%Y'),'%d/%m/%Y') /*este ultimo filtro es para traer todas las ops nuevas del mes*/
group by header.patientId, nroOp,type_of_service,estatico
/*fecha de vencimiento convertido a fecha DATE_FORMAT(STR_TO_DATE(fechas.fechaVencimiento,'%d/%m/%Y'),'%d/%m/%Y') */