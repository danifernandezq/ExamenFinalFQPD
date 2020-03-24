select username, password
from users
inner join delivery on users.username = delivery.clntusername and delivery.modeoftransport = 'Bus'
