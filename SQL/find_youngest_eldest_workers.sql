select 'YOUNGEST' as TYPE,name , birthday from worker
where birthday = (SELECT MAX(birthday) from worker)
UNION
select 'ELDEST' as TYPE,name , birthday from worker
where birthday = (SELECT MIN(birthday) from worker);