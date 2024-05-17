def firstFit(blocks, processes):
    allocation = []
    blocked=[]
    for i in range(0, len(processes)):
        allocation.append(-1)
        blocked.append(False)

    for i in range(0, len(blocks)):
        blocked.append(False)
    internalFrag=0
    print(f"Process\t\tProcess Size\t\tAllocated Block Size")
    for i in range(0, len(processes)):
        firstIdx=-1
        for j in range(0, len(blocks)):
            if(processes[i]<=blocks[j] and blocked[j]!=True):
                firstIdx=j
                break
        printBlockAllocated=-1
        if(firstIdx==-1):
            allocation[i]=-1
        else:
            allocation[i] = firstIdx
            spaceLeft = blocks[firstIdx] - processes[i]
            if(spaceLeft>0):
                internalFrag += spaceLeft
            printBlockAllocated = blocks[firstIdx]
            blocked[firstIdx] = True
        
        print(f"{i+1}\t\t{processes[i]}\t\t{printBlockAllocated}")
    print(f"Internal frag {internalFrag}")
    return


blocks = [100, 500, 200, 300, 600]
processes =[212 , 417, 112, 426]

firstFit(blocks, processes)
print("\n\n")
