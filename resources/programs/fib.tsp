const start 1
movi start _ r0
movi start _ r1
mov in _ r4
label loop
mov r0 _ out
add r0 r1 r2
mov r1 _ r0
mov r2 _ r1
addi r3 1 r3
jl r3 r4 loop
exit