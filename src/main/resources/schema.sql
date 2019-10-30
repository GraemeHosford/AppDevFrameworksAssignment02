CREATE TABLE IF NOT EXISTS User
(
    userId       INT         NOT NULL AUTO_INCREMENT,
    userName     VARCHAR(50) NOT NULL,
    userPhone    CHAR(10)    NOT NULL,
    userEmail    VARCHAR(30) NOT NULL,
    userPassword VARCHAR(30) NOT NULL,
    PRIMARY KEY (userId)
);

CREATE TABLE IF NOT EXISTS Job
(
    jobId            INT          NOT NULL AUTO_INCREMENT,
    jobName          VARCHAR(30)  NOT NULL,
    jobDescription   VARCHAR(100) NOT NULL,
    jobPublishedDate DATETIME     NOT NULL,
    PRIMARY KEY (jobId)
);

CREATE TABLE IF NOT EXISTS UserJobs
(
    userId INT NOT NULL,
    jobId  INT NOT NULL,
    PRIMARY KEY (userId, jobId),
    FOREIGN KEY (userId) REFERENCES User (userId),
    FOREIGN KEY (jobId) REFERENCES Job (jobId)
);

CREATE TABLE IF NOT EXISTS Bid
(
    bidId     INT    NOT NULL AUTO_INCREMENT,
    bidAmount DOUBLE NOT NULL,
    PRIMARY KEY (bidId)
);

CREATE TABLE IF NOT EXISTS UserBids
(
    userId INT NOT NULL,
    bidId  INT NOT NULL,
    PRIMARY KEY (userId, bidId),
    FOREIGN KEY (userId) REFERENCES User (userId),
    FOREIGN KEY (bidId) REFERENCES Bid (bidId)
);

CREATE TABLE IF NOT EXISTS JobBids
(
    jobId INT NOT NULL,
    bidId INT NOT NULL,
    PRIMARY KEY (jobId, bidId),
    FOREIGN KEY (jobId) REFERENCES Job (jobId),
    FOREIGN KEY (bidId) REFERENCES Bid (bidId)
);