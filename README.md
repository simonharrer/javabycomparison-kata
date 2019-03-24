# Java by Comparison Kata Creation

```bash
# count comparisons (per comparison)
$ git grep -ho "//[ ]JC .*" | sort | uniq -c
# count comparisons (unique total)
$ git grep -ho "//[ ]JC .*" | sort | uniq | wc -l
# check which rules are not yet available in the code
$ ruby status.rb
# remove comparison marker comments
$ ruby prepare.rb

# release new kata version
# REQUIRES ../kata directory
$ ./release
```
