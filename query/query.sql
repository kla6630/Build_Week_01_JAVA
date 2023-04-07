select * from tessere;
select * from abbonamenti;
select * from venditore;

/*delete from abbonamenti where id = 44;*/

SELECT ab FROM abbonamenti ab 
inner join tessere te on te.id=ab.tessera_id 
where TO_DATE('25-12-2022','DD-MM-YYYY') >= te.data_Attivazione and TO_DATE('25-12-2022','DD-MM-YYYY') <= te.data_Scadenza 
and TO_DATE('25-12-2022','DD-MM-YYYY') >= ab.data_Emissione and TO_DATE('25-12-2022','DD-MM-YYYY')<= ab.dataScadenza 
and te.id=1;

