def doesPageExist(page, frames,nP,nF):
    exist = False
    for i in range(0,nF):
        if(page==frames[i]):
            exist=True
            break
    
    return exist

def fifo(pages,nP,nF):
    hitCount=0
    frames=[]
    print(f"NF {nF} nP {nP}")
    for i in range(0,nF):
        frames.append(pages[i])
        print(f"Page {pages[i]} ==> Frames {frames} | Fault")


        frameIdxToBeRemoved=0
    for i in range(nF,nP):
        if(doesPageExist(pages[i], frames, nP,nF)):
                hitCount+=1
                print(f"Page {pages[i]} ==> Frames {frames} | HIT")
        else:
                frames[frameIdxToBeRemoved] = pages[i]
                frameIdxToBeRemoved = (frameIdxToBeRemoved+1)%nF
                print(f"Page {pages[i]} ==> Frames {frames} | Fault")
    
    print(f"No of hits {hitCount}")
    print(f"No of faults {abs(hitCount-nP)}")


            

nP = int(input("Enter no of pages: "))
pages=[]
for i in range(0,nP):
    pages.append(int(input()))

nF = int(input("Enter no of frames: "))

fifo(pages,nP,nF)
