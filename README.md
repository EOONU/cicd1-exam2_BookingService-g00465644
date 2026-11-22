# Coding Test – Self-assessment

| Area | What was in my original submission | What needed fixing |
| --- | --- | --- |
| Booking model | I added an entity and a generated ID. The file also contained an unfinished Category class. | Create one Booking entity and store the external room ID on the booking. |
| Repository | I attempted to extend JpaRepository, but used BookingService as the entity type, used primitive long as a generic type, and declared the repository twice. | Use one interface extending JpaRepository<Booking, Long>. |
| Request DTO | I started a create request, but the file contained invalid Java and statements outside a method. | Put the request in its own file and validate its fields. |
| Room lookup | I enabled Feign and configured the Room Service URL. My client called /Room/{id} and returned its own interface type. | Call /api/rooms/{id} and read the response into a room DTO. |
| Service | I added @Service, but the constructor did not store the repository and the methods were unfinished. | Inject the repository and room client, check capacity, and save valid bookings. |
| Controller | I had a health endpoint and an unfinished @GetMapping. | Complete the endpoints to create, list and retrieve bookings. |

The original submission did not compile, so I could not demonstrate a working booking request from that commit.
