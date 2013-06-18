
    create table shoplifter.Address (
        id bigint not null auto_increment,
        city varchar(255),
        country varchar(255),
        street varchar(255),
        streetNumber integer,
        zip integer,
        primary key (id)
    );

    create table shoplifter.Friendship (
        id bigint not null auto_increment,
        applicant tinyblob,
        recipient tinyblob,
        status varchar(255),
        primary key (id)
    );

    create table shoplifter.Person (
        id bigint not null auto_increment,
        email varchar(255),
        login varchar(255) unique,
        name varchar(255),
        password varchar(255),
        phone varchar(255),
        surname varchar(255),
        address_id bigint,
        primary key (id)
    );

    create table shoplifter.Person_Person (
        Person_id bigint not null,
        requestForMe_id bigint not null,
        myRequests_id bigint not null,
        friends_id bigint not null,
        unique (friends_id),
        unique (requestForMe_id),
        unique (myRequests_id)
    );

    create table shoplifter.ShopItem (
        id bigint not null auto_increment,
        count integer,
        isBought bit,
        name varchar(255),
        primary key (id)
    );

    create table shoplifter.ShopList (
        id bigint not null auto_increment,
        applicant tinyblob,
        buyer tinyblob,
        deadlineDate date,
        deadlineTime time,
        reward varchar(255),
        status varchar(255),
        primary key (id)
    );

    create table shoplifter.ShopList_ShopItem (
        ShopList_id bigint not null,
        goods_id bigint not null,
        unique (goods_id)
    );

    alter table shoplifter.Person 
        add index FK8E4887759DF16BF3 (address_id), 
        add constraint FK8E4887759DF16BF3 
        foreign key (address_id) 
        references shoplifter.Address (id);

    alter table shoplifter.Person_Person 
        add index FKB9039F7F574E0BC1 (Person_id), 
        add constraint FKB9039F7F574E0BC1 
        foreign key (Person_id) 
        references shoplifter.Person (id);

    alter table shoplifter.Person_Person 
        add index FKB9039F7FD72DCB04 (requestForMe_id), 
        add constraint FKB9039F7FD72DCB04 
        foreign key (requestForMe_id) 
        references shoplifter.Person (id);

    alter table shoplifter.Person_Person 
        add index FKB9039F7FBBCCB581 (friends_id), 
        add constraint FKB9039F7FBBCCB581 
        foreign key (friends_id) 
        references shoplifter.Person (id);

    alter table shoplifter.Person_Person 
        add index FKB9039F7F99CF2BC6 (myRequests_id), 
        add constraint FKB9039F7F99CF2BC6 
        foreign key (myRequests_id) 
        references shoplifter.Person (id);

    alter table shoplifter.ShopList_ShopItem 
        add index FK10ECAA5424E6DA34 (goods_id), 
        add constraint FK10ECAA5424E6DA34 
        foreign key (goods_id) 
        references shoplifter.ShopItem (id);

    alter table shoplifter.ShopList_ShopItem 
        add index FK10ECAA548DF515C1 (ShopList_id), 
        add constraint FK10ECAA548DF515C1 
        foreign key (ShopList_id) 
        references shoplifter.ShopList (id);
