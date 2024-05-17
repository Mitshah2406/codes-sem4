def worstFit(blocks, processes):
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
        maxBlock=-1
        worstIdx=-1
        for j in range(0, len(blocks)):
            if(maxBlock<blocks[j]):
                if(processes[i]<=blocks[j] and blocked[j]!=True):

                    worstIdx=j
                    maxBlock=blocks[j]
        printBlockAllocated=-1
        if(worstIdx==-1):
            allocation[i]=-1
        else:
            allocation[i] = worstIdx
            spaceLeft = blocks[worstIdx] - processes[i]
            if(spaceLeft>0):
                internalFrag += spaceLeft
            printBlockAllocated = blocks[worstIdx]
            blocked[worstIdx] = True
        
        print(f"{i+1}\t\t{processes[i]}\t\t{printBlockAllocated}")
    print(f"Internal frag {internalFrag}")
    return


blocks = [100, 500, 200, 300, 600]
processes =[212 , 417, 112, 426]

worstFit(blocks, processes)
print("\n\n")
