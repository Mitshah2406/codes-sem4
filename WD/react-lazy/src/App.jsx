import  { Suspense, lazy, useState, useEffect } from "react";

const Card1 = lazy(() => import('./components/card1'));

function App() {
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    // Simulate loading delay
    const timer = setTimeout(() => {
      setIsLoading(false);
    }, 2000); // Change the delay time as needed (in milliseconds)

    return () => clearTimeout(timer);
  }, []);

  return (
    <>
      <h1>Lazy Load</h1>
      <Suspense fallback={<div>Component1 is loading, please wait...</div>}>
        {isLoading ? (
          <div>Loading...</div>
        ) : (
          <Card1 />
        )}
      </Suspense>
    </>
  );
}

export default App;
