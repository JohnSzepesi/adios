CREATE TABLE currency (
    currency_id int PRIMARY KEY auto_increment,
    currency_name varchar(5)
    );
    
CREATE TABLE financial_coordinator (
    financialcoordinator_id int PRIMARY KEY auto_increment,
    full_name_fincoord varchar(120) NOT NULL,
    phone varchar(20),
    email varchar(30) not null
    );

CREATE TABLE financial_status (
    financialstatus_id int PRIMARY KEY auto_increment,
    financial_status_name varchar(45)
    );
    
CREATE TABLE funder (
    funder_id   INTEGER PRIMARY KEY auto_increment,
    name varchar(200)    NOT NULL,
    webpage varchar(200)    NOT NULL,
    shortName varchar(10)    NOT NULL,
    phone varchar(20)    NOT NULL,
    email varchar(30)    NOT NULL
    );
    
CREATE TABLE funder_contact (
    fundercontact_id   INTEGER PRIMARY KEY auto_increment,
    full_name_fundcont varchar(200)    NOT NULL,
    phone varchar(20),
    email varchar(30),
    funder_id INTEGER,
    foreign key (funder_id)
    references funder (funder_id)
    on update cascade
    on delete cascade
    );
    
CREATE TABLE unit (
    unit_id int PRIMARY KEY auto_increment,
    unit_name varchar(125),
    unit_short_name varchar (30)
    );

CREATE TABLE project_administrator (
    projectadministrator_id int PRIMARY KEY auto_increment,
    full_name_proadmin varchar(125) not null,
    mobile varchar(20),
    email varchar(45),
    unit_id int,
    foreign key (unit_id)
    references unit (unit_id)
    on update cascade
    on delete cascade
    );
    
CREATE TABLE project_manager (
    projectmanager_id int PRIMARY KEY auto_increment,
    full_name_promanag varchar(125) not null,
    mobile varchar(20),
    email varchar(45) not null
);

CREATE TABLE project_status (
    projectstatus_id int PRIMARY KEY auto_increment,
    project_status_name varchar(125) not null
);

CREATE TABLE tender (
    tender_id int PRIMARY KEY auto_increment,
    tender_name varchar(200),
    tender_shortname varchar(30),
    tender_webpage varchar(120) NOT NULL,
    notification_deadline date,
    financial_deadline date,
    faculty_deadline date,
    tender_center_deadline date not null,
    submission_deadline date not null,
    funder_id int,
    foreign key (funder_id)
    references funder (funder_id)
    on update cascade
    on delete cascade
    );
 
 CREATE TABLE user_right (
    userright_id int PRIMARY KEY auto_increment,
    user_right_name varchar(40) 
   );
   
CREATE TABLE user (
    user_id int PRIMARY KEY auto_increment,
    username varchar(40) not null,
    password varchar(120) not null,
    salt varchar(120),
    userright_id int,
    foreign key (userright_id)
    references user_right (userright_id)
    on update cascade
    on delete cascade
   );
   
CREATE TABLE projects (
    projects_id INTEGER PRIMARY KEY auto_increment,
    identification_number varchar(200) not null,
    title varchar(200) NOT NULL,
    acronyme varchar(45),
    start_date date not null,
    end_date date not null,
    job_number varchar(45),
    remittance_code varchar(45),
    division varchar(45),
    source varchar(45),
    eper_number varchar(45),
    total_aid int,
    total_cost int,
    firstws_start date,
    firstws_end date,
    secondws_start date,
    secondws_end date,
    thirdws_start date,
    thirdws_end date,
    fourthws_start date,
    fourthws_end date,
    fifthws_start date,
    fifthws_end date,
    sixthws_start date,
    sixthws_end date,
    funder_id int,
    foreign key (funder_id)
    references funder (funder_id)
    on update cascade
    on delete cascade,
    fundercontact_id int,
    foreign key (fundercontact_id)
    references funder_contact (fundercontact_id)
    on update cascade
    on delete cascade,
    projectstatus_id int,
    foreign key (projectstatus_id)
    references project_status (projectstatus_id)
    on update cascade
    on delete cascade,
    projectadministrator_id int,
    foreign key (projectadministrator_id)
    references project_administrator (projectadministrator_id)
    on update cascade
    on delete cascade,
    financialcoordinator_id int,
    foreign key (financialcoordinator_id)
    references financial_coordinator (financialcoordinator_id)
    on update cascade
    on delete cascade,
    projectmanager_id int,
    foreign key (projectmanager_id)
    references project_manager (projectmanager_id)
    on update cascade
    on delete cascade,
    financialstatus_id int,
    foreign key (financialstatus_id)
    references financial_status (financialstatus_id)
    on update cascade
    on delete cascade,
    currency_id int,
    foreign key (currency_id)
    references currency (currency_id)
    on update cascade
    on delete cascade,
    tender_id int,
    foreign key (tender_id)
    references tender (tender_id)
    on update cascade
    on delete cascade,
    unit_id int,
    foreign key (unit_id)
    references unit (unit_id)
    on update cascade
    on delete cascade
    );



