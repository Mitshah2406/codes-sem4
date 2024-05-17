def doesPageExist(page, frames,nP,nF):
    exist = False
    for i in range(0,nF):
        if(page==frames[i]):
            exist=True
            break
    
    return exist
def findLastOccurence(pages, start, end, target):
     idx=-1
     for i in range(end, -1,-1):
          if(target==pages[i]):
               idx=i
               break
     return idx
def lru(pages,nP,nF):
    hitCount=0
    frames=[]
    print(f"NF {nF} nP {nP}")
    for i in range(0,nF):
        frames.append(-1)


    for i in range(0,nP):
        if(doesPageExist(pages[i], frames, nP,nF)):
                hitCount+=1
                print(f"Page {pages[i]} ==> Frames {frames} | HIT")
        else:
                currentLRU = findLastOccurence(pages, 0, i-1, frames[0])
                frameIdxToBeRemoved=0

                for j in  range(1,nF):
                     newLRU = findLastOccurence(pages, 0,i-1, frames[j])

                     if(newLRU<currentLRU):
                          currentLRU=newLRU
                          frameIdxToBeRemoved=j
                

                frames[frameIdxToBeRemoved] = pages[i]
                print(f"Page {pages[i]} ==> Frames {frames} | Fault")
    
    print(f"No of hits {hitCount}")
    print(f"No of faults {abs(hitCount-nP)}")


            

nP = int(input("Enter no of pages: "))
pages=[]
for i in range(0,nP):
    pages.append(int(input()))

nF = int(input("Enter no of frames: "))

lru(pages,nP,nF)
