drop database if exists itunesbackup;

create database itunesbackup;
use itunesbackup;

drop table if exists playlist_track_link;
drop table if exists playlist;
drop table if exists track;
drop table if exists library;


create table user(
  user_id int(11) not null AUTO_INCREMENT,
  user_name varchar(45) not null,
  user_password varchar(45) not null,
  primary key (user_id)
) ENGINE=InnoDB;

CREATE TABLE library (
  library_id VARCHAR(45) NOT NULL,
  user_id INT NOT NULL,
  PRIMARY KEY (library_id),
  CONSTRAINT user_id
    FOREIGN KEY (user_id)
    REFERENCES user (user_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;

create table playlist(
  playlist_id int(11),
  playlist_name varchar(45),
  -- library_id VARCHAR(45) NOT NULL,
  primary key(playlist_id)
  -- CONSTRAINT library_id
  --   FOREIGN KEY (library_id)
  --   REFERENCES library (library_id)
  --   ON DELETE CASCADE
  --   ON UPDATE CASCADE
) ENGINE=InnoDB;







create table track(
  track_id int(11) not null,
  track_name varchar(45) not null,
  track_artist varchar(45) not null,
  track_album varchar(45) not null,
  primary key (track_id)
) ENGINE=InnoDB;


CREATE TABLE playlist_track_link(
  id VARCHAR(45) not null,
  track_id INT NOT NULL COMMENT '',
  playlist_id INT NOT NULL COMMENT '',
  track_obj INT NOT NULL,
  playlist_obj INT NOT NULL,
  PRIMARY KEY (id)  COMMENT '',
  CONSTRAINT `track_obj`
    FOREIGN KEY (`track_obj`)
    REFERENCES track (`track_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `playlist_obj`
    FOREIGN KEY (`playlist_obj`)
    REFERENCES playlist (`playlist_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;


