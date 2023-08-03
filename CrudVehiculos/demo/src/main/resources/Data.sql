

INSERT INTO cartypes(id,types,price)
VALUES (100,'SUV',30000000);

INSERT INTO cars(id,cartype,brand,model)
VALUES (1000,100,'LAND ROVER','DEFENDER');

INSERT INTO cars(id,cartype,brand,model)
VALUES (1001,100,'TOYOTA','HILUX');

INSERT INTO rents(id,customer,car_id,rented_days,start_rent,end_rent,total_price)
VALUES (10,'genaro',1000,4,'2023-2-14','2023-2-16',400000)