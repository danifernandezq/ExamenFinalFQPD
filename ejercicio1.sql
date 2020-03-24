select id, clientusername, orderid, gendate, duedate, amount
from invoice
inner join clients on clients.username = invoice.clientusername and clientusername = 'nc1'


