Parking Lot (or any other LLD for that matter)

## Phase 1 — Requirements → Nouns & Verbs (2-3 mins)
Don't think about code yet. Read your requirements and just extract:
Nouns → become entities
Verbs → become methods or flows


## Phase 2 —  Bottom-Up: Build Entities (5-7 mins)
Start with the dumbest, most obvious entities first — no orchestrator yet. Just model the real world.

The thinking goes like this:

- "A Vehicle exists. What does it know about itself?" → its ID and its type. Nothing else. Vehicle is born.
- "A ParkingSpot exists. What does it know?" → its ID, its type, whether it's free. ParkingSpot is born.
- "Spots live on Floors. What does a Floor know?" → its number, its list of spots. ParkingFloor is born.
- "When a vehicle parks, something needs to track that transaction." → entry time, exit time, which spot, which vehicle. Ticket is born.

At this point you have 4-5 clean, dumb entities. No logic yet. No orchestrator. Each entity only knows about itself.

This is the right order because entities are stable — they don't change when business logic changes. You're building the foundation first.

## 3. Phase 3 — Top-Down: Orchestrator + Flows (10-15 mins)
Now ask: "Who drives the action?"

You have entities but nothing makes them talk to each other. That's the orchestrator's job. The thinking goes:

"Something needs to handle a vehicle arriving." → It needs floors to search, tickets to issue, a place to store active tickets. → ParkingLotManager is born.

Now walk through each flow and assign responsibility:

- ### parkVehicle:

    - Find a free spot → who decides which spot? Not the manager — that logic can vary. Extract `SpotAllocationStrategy`.
    - Mark it occupied → the spot itself should own this, atomically. tryOccupy() on ParkingSpot.
    - Issue a ticket → manager creates and stores it.

- ### unparkVehicle: 
  - Retrieve the ticket → manager owns `activeTickets`.
  - Compute cost → who decides the price? Not the manager — pricing can vary. Extract `PricingStrategy`.
  - Free the spot → spot owns this. `spot.free()`.

Notice the pattern — every time you say "who decides X and it could vary", that's your signal to extract a Strategy interface. You're not applying Strategy because you know the pattern. You're applying it because the problem tells you to.

