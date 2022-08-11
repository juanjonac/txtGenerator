select replace(header.patientId,"-","") as nroAfiliado, header.WO_id,detail.type_of_service,insumosEstaticos.CodigoTxt,"MES","31", detail.serviceId
from tsm.wo_headers header, tsm.equivalenciasinsumosestaticos insumosEstaticos,tsm.wo_details detail
where insumosEstaticos.CodigoBD=detail.serviceId and header.WO_id=detail.WO_originalId and detail.type_of_service like 'Otros'