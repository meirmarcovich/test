select order_year, order_month, customerid, order_sum
from 
	(select year (orderdate) order_year, month (orderdate) order_month , 
    customerid , sum(od.unitprice * od.quantity) order_sum 
	from  `order` o join order_detail od 
	on o.orderid = od.orderid 
	group by order_year , order_month, customerid) zzz
group by order_year, order_month
having order_sum = max(order_sum)
