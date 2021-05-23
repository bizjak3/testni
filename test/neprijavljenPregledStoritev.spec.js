describe('Poizkus priti na stran dodaj storitev ne, da bi bil prijavljen', function () {
    it('Obisk strani dodajanje storitve in preusmerjanje na root', function () {
        cy.visit('http://localhost:4200/login')

        cy.url()
            .should('include', '/login')

        cy.visit('http://localhost:4200/pregled_storitev')

        cy.url()
            .should('include', '/')
        cy.wait(500)

        cy.contains('Pasjehodec')
        cy.url()
            .should('include', '/')
    });
});
