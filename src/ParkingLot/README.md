Parking Lot LLD

1. I'll follow this flow:
   1. Clarify requirements
   2. Brief High Level flow
   3. Core Entities
   4. Main flows (Assign responsibilities)
   5. Orchestration + policies + strategies
2. First off, to ensure I don't assume any incorrect assumptions, I'd clarify the requirements w the interviewer:
   1. Multiple floors?
   2. Ticket System employed?
   3. Need to pay for a ticket?
   4. Vehicle types: two-wheeler, four-wheeler, utility vans, etc.
   5. Different types of parking slots. (for various vehicles)
   6. Parking mechanism: Flat or Slot based?
   7. Higher consistency, i.e., no two people should be able to book a same slot at the same time.
3. Briefing the high-level flow:
   1. Vehicle would enter
   2. It'll buy a ticket
   3. Check for slot availability
   4. Assign a parking slot accordingly
   5. Define strategies for assigning parking slot (based on user input). Like if the vehicle wants slot near the entry or the exit.
   6. At the exit, price is computed based on the ticket lifecyle.
4. Mapping out the core entities. Now, I'll start simple and extend for extensibility.
   1. Vehicle, Vehicle enum
   2. Ticket
   3. Parking Lot Floor
   4. ParkingSlot, ParkingSlot enum
   5. ParkingLotManager (would behave as a single source of brain; Orchestrator)
   6. SpotAllocation strategies
   7. Pricing strategies
5. Now, I'll outline the main flow:
   1. **/parkVehicle:** Vehicle enters, checks for spot availability, assign slot, and marks it occupied.
   2. **/unparkVehicle:** Logs the exit time, compute cost, & frees the slot.
   3. Now to orchestrate these flows, I'll introduce **ParkingLotManager**.