DROP DATABASE IF EXISTS dice_game;
create database dice_game;
use dice_game;

create table users(
id int primary key auto_increment,
`name` varchar(80),
average_rate double,
user_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
create table games(
id int primary key auto_increment,
user_id INT,
dice1 int not null,
dice2 int not null,
result varchar(10),
game_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES users(id)
);
