select  replace(patientId, "-", "") as nroAfiliado,ugl
from wo_headers  
/*where replace(patientId, "-", "") =15089621080901*/
group by nroAfiliado,ugl  /*agrupo para evitar duplicados*/