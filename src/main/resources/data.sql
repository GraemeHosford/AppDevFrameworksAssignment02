INSERT INTO User
VALUES (1, 'Graeme Hosford', '0871234567', 'graeme.hosford@mycit.ie', 'FakePassword1'),
       (2, 'Rob Morgan', '0874646291', 'rob.morgan@mycit.ie', 'Password55'),
       (3, 'John Smith', '0862234015', 'smith.john55@gmail.com', 'KindaWantCakeRightNow'),
       (4, 'Michael Lastname', '0873329018', 'michael.lastname@gmail.com', 'MyNameIsTerrible34'),
       (5, 'Sam Person', '0891230238', 'samperson31@gmail.com', 'MakingUpNamesIsHArd'),
       (6, 'Homer Simpson', '0851042306', 'homer.simpson@springfield.com', 'Springfield1989'),
       (7, 'Rand al Thor', '0852334397', 'randalthor@wot.com', 'FantasyBookNamesFTW');

INSERT INTO Job
VALUES (1, 'Install cabinet', 'Need help installing new furniture', PARSEDATETIME('20191101054334', 'yyyyMMddHHmmss')),
       (2, 'Retile Kitchen', 'The tiles in the kitchen need to be replaced, all tools provided',
        PARSEDATETIME('2019093110341', 'yyyyMMddHHmmss')),
       (3, 'Paint bedroom', 'Bedroom must be painted. Paint already bought but must bring own brushes',
        PARSEDATETIME('20191031153316', 'yyyyMMddHHmmss'));

INSERT INTO UserJobs
VALUES (1, 3),
       (2, 1),
       (3, 2);

INSERT INTO Bid
VALUES (1, 50.34),
       (2, 23.00),
       (3, 19.67),
       (4, 34.56),
       (5, 29.88),
       (6, 29.85),
       (7, 63.22),
       (8, 55.26),
       (9, 37.61),
       (10, 34.55);

INSERT INTO UserBids
VALUES (4, 1),
       (4, 4),
       (4, 9),
       (5, 6),
       (5, 7),
       (6, 3),
       (6, 5),
       (6, 8),
       (7, 2),
       (7, 10);

INSERT INTO JobBids
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (2, 6),
       (3, 7),
       (3, 8),
       (3, 9),
       (3, 10);