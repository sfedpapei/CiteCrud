-- delete old data
delete from employee;

-- add few employees
insert into employee values(1, 'Greg', CURRENT_DATE,NULL);
insert into employee values(2, 'Aura', CURRENT_DATE,1);
insert into employee values(3, 'Oleg', CURRENT_DATE,1);
insert into employee values(4, 'Paul', CURRENT_DATE,1);
insert into employee values(5, 'Phil', CURRENT_DATE,1);
insert into employee values(6, 'Pete', CURRENT_DATE,3);