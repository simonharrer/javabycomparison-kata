# Java by Comparison Kata

```bash
# count comparisons (per comparison)
$ git grep -ho "//[ ]JC .*" | sort | uniq -c
# count comparisons (unique total)
$ git grep -ho "//[ ]JC .*" | sort | uniq | wc -l
```