-- Used by Spring Remember Me API.
CREATE TABLE persistent_logins (

                                 username varchar(64) not null,
                                 series varchar(64) not null,
                                 token varchar(64) not null,
                                 last_used timestamp not null,
                                 PRIMARY KEY (series)

);

-- top lawyers query
select u.name, u.surname, answer.user_id,count(1) as num_answers
from answer,user u where u.user_type='LAWYER' and u.id=answer.user_id group by user_id order by num_answers desc limit 1;