# Client Fresh Desk
###### using api fresh desk in java
### Examples
##### Use
Get user by Id

        UserRepository userRepository = new UserRepository();
        return userRepository.find(id);
Post user

        Long identification = new Random().nextLong();
        UserRepository userRepository = new UserRepository();
        User u = new User();
        u.setEmail("user"+ identification+"@facape.br");
        u.setPhone("1234567");
        u.setMobile("1234567");
        u.setName("user"+identification);
        u = userRepository.save(u);

Put user

First find e get user and set in var "u"

        u.setName("User updateDoZero: "+new Date());
        UserRepository userRepository = new UserRepository();
        userRepository.save(u);

List users

        UserRepository userRepository = new UserRepository();
        return userRepository.findAll();
### Tickets
Post

        Ticket t = new Ticket();
        t.setEmail("flavio@hotmail.com");
        t.setDescription("Conteudo da treta man");
        t.setPriority(1);
        t.setStatus(2);
        t.setSubject("Ticket test por luciano");
        t.addCc_email("marcusvinicius@hotmail.com");//.addCc_email("dasdsa@hotmail.com");
        t.setResponder_id(14001031858l);
        TicketRepository ticketRepository = new TicketRepository();
        Ticket ticket = ticketRepository.save(t);


Get

        TicketRepository ticketRepository = new TicketRepository();
        Ticket ticket = ticketRepository.find(id);
Put

First get an ticket and set in var ticke

        ticke.setStatus(StatusType.Closed.getValue());
        ticke.setPriority(PriorityType.Urgent.getValue());
        TicketRepository ticketRepository = new TicketRepository();
        ticke = ticketRepository.save(ticke);

See more examples in class TicketTest.java