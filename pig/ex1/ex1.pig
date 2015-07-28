A = LOAD 'file1.txt' using PigStorage(',') AS (nm, dp, id);
B = LOAD 'file2.txt' using PigStorage(',') AS (id, dt, hr);
C = FILTER B by hr > 8;
D = JOIN C BY id, A BY id;
E = GROUP D BY A::id;
F = FOREACH E GENERATE $1.dp,group,$1.nm, AVG($1.hr);
STORE F INTO '/tmp/pig_output/';
