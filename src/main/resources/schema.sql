CREATE TABLE IF NOT EXISTS User
(
    customerId       INT         NOT NULL AUTO_INCREMENT,
    customerName     VARCHAR(50) NOT NULL,
    customerPhone    CHAR(10)    NOT NULL,
    customerEmail    VARCHAR(30) NOT NULL,
    customerPassword VARCHAR(30) NOT NULL,
    PRIMARY KEY (customerId)
);

CREATE TABLE IF NOT EXISTS Job
(
    jobId          INT          NOT NULL AUTO_INCREMENT,
    jobName        VARCHAR(30)  NOT NULL,
    jobDescription VARCHAR(100) NOT NULL,
    jobPublishDate DATETIME     NOT NULL,
    PRIMARY KEY (jobId)
);

CREATE TABLE IF NOT EXISTS UserJobs
(
    customerId INT NOT NULL,
    jobId      INT NOT NULL,
    PRIMARY KEY (customerId, jobId),
    FOREIGN KEY (customerId) REFERENCES User (customerId),
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
    customerId INT NOT NULL,
    bidId      INT NOT NULL,
    PRIMARY KEY (customerId, bidId),
    FOREIGN KEY (customerId) REFERENCES User (customerId),
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